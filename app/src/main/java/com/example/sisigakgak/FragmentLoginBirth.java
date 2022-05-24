package com.example.sisigakgak;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class FragmentLoginBirth extends Fragment {
    private SharedViewModel model;
    private Button nextBtn;
    private TextView textBirth;
    private Button inputBtn;
    Intent intent;
    SpeechRecognizer mRecognizer;
    final int PERMISSION = 1;

    public static FragmentLoginBirth newInstance(){
        return new FragmentLoginBirth();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Fragment로 불러올 xml 파일을 view로 가져옴.
        View view = inflater.inflate(R.layout.fragment_login_birth, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 음성 인식 - 주민등록 번호
        textBirth = view.findViewById(R.id.text_birth);

        // 안드로이드 6.0버전 이상인지 체크해서 퍼미션 체크
        if(Build.VERSION.SDK_INT >= 23){
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO},PERMISSION);
        }
        RecognitionListener listener = new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
                // 말하기 시작할 준비가되면 호출
                Toast.makeText(getActivity(),"음성인식 시작",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBeginningOfSpeech() {
                // 말하기 시작했을 때 호출
            }

            @Override
            public void onRmsChanged(float rmsdB) {
                // 입력받는 소리의 크기를 알려줌
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                // 말을 시작하고 인식이 된 단어를 buffer에 담음
            }

            @Override
            public void onEndOfSpeech() {
                // 말하기를 중지하면 호출
            }

            @Override
            public void onError(int error) {
                // 네트워크 또는 인식 오류가 발생했을 때 호출
                String message;

                switch (error) {
                    case SpeechRecognizer.ERROR_AUDIO:
                        message = "오디오 에러";
                        break;
                    case SpeechRecognizer.ERROR_CLIENT:
                        message = "클라이언트 에러";
                        break;
                    case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                        message = "퍼미션 없음";
                        break;
                    case SpeechRecognizer.ERROR_NETWORK:
                        message = "네트워크 에러";
                        break;
                    case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                        message = "네트웍 타임아웃";
                        break;
                    case SpeechRecognizer.ERROR_NO_MATCH:
                        message = "찾을 수 없음";
                        break;
                    case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                        message = "RECOGNIZER 가 바쁨";
                        break;
                    case SpeechRecognizer.ERROR_SERVER:
                        message = "서버가 이상함";
                        break;
                    case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                        message = "말하는 시간초과";
                        break;
                    default:
                        message = "알 수 없는 오류임";
                        break;
                }

                Toast.makeText(getActivity(), "에러 발생 : " + message,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResults(Bundle results) {
                // 인식 결과가 준비되면 호출
                // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줌
                ArrayList<String> matches =
                        results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                for(int i = 0; i < matches.size() ; i++){
                    textBirth.setText(matches.get(i));
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                // 부분 인식 결과를 사용할 수 있을 때 호출
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                // 향후 이벤트를 추가하기 위해 예약
            }
        };


        // RecognizerIntent 생성
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR"); // 언어 설정

        // STT Start 버튼 클릭 시 객체에 Context와 listener를 할당
        inputBtn = view.findViewById(R.id.input_birth);
        inputBtn.setOnClickListener(e -> {
            mRecognizer = SpeechRecognizer.createSpeechRecognizer((LoginActivity)getActivity()); // 새 SpeechRecognizer 를 만드는 팩토리 메서드
            mRecognizer.setRecognitionListener(listener); // 리스너 설정
            mRecognizer.startListening(intent); // 듣기 시작
        });


        // 다음으로 버튼
        nextBtn = view.findViewById(R.id.btn_next);
        nextBtn.setOnClickListener(item -> {
            // 값 전달할 모델 생성
            model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            // 다음 프래그먼트(화면)으로 값 전달
            model.setBirth(textBirth.getText());

            // 다음 화면(프래그먼트) 띄우기
            ((LoginActivity)getActivity()).change_fragment(FragmentLoginPhone.newInstance());
        });
    }
}
