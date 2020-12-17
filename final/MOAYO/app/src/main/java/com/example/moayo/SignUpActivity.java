package com.example.moayo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity{
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    public Map<String, Object> user = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.signupButton).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.signupButton:
                    signup();
                    break;
            }
        }
    };
    private void signup(){
        String email = ((EditText)findViewById(R.id.Email_EditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.PasswordEditText)).getText().toString();
        String phoneNumber = ((EditText)findViewById(R.id.phoneNumberEditText2)).getText().toString();
        String name = ((EditText)findViewById(R.id.nameEditText2)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.PasswordCheckEditText)).getText().toString();

        if(email.length()> 0 &&password.length()>0&&passwordCheck.length()>0 &&name.length() > 0 && phoneNumber.length() > 10 ) {
            user.put("name", name);
            user.put("phoneNumber", phoneNumber);
            user.put("seatNumber", " ");
            user.put("arrivalLocation" ," ");
            user.put("departureLocation"," ");
            user.put("bus type"," ");
            user.put("amount"," ");
            user.put("departure time"," ");
            user.put("arrival time"," ");
            user.put("date","");
            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    if (task.getException() != null) {
                                        startToast(task.getException().toString());
                                    }
                                }

                            }
                        });

                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                startToast("회원가입에 성공하였습니다.");
                                DocumentReference savedId = db.collection("users").document("userDataId");
                                savedId
                                        .update("userDataId",documentReference.getId());
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                myStartActivity(LoginActivity.class);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            } else {
                startToast("비밀번호가 일치하지 않습니다.");
            }

        }else{
            startToast("필수항목들을 제대로 입력해 주세요");
        }

    }
    private void startToast(String msg){
        Toast.makeText( this ,msg,Toast.LENGTH_SHORT).show();
    }
    private void myStartActivity(Class c){
        Intent intent=new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}

