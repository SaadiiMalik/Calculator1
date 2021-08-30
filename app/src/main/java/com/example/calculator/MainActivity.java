package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    ImageView btn_dot, btn_equal, btn_ac, btn_module, btn_plus, btn_minus, btn_multiply, btn_divide, btn_del;

    TextView inputTxt, outputTxt;

    String data;
    int chr = 0;
    boolean ToShowResult = false;
    boolean ToShowNow=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);


        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ac = findViewById(R.id.btn_ac);
        btn_module = findViewById(R.id.btn_module);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);

        inputTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //String last=  charSequence.subSequence(charSequence.length()-1, charSequence.length());

                if(ToShowResult){
                    ToShowNow=true;
                }
                CharSequence cs="";
                try {
                    cs = charSequence.subSequence(charSequence.length() - 1, charSequence.length());

                }
                catch (Exception e){ }

                //Log.d("LogHere", cs +"");
                String css=String.valueOf(cs);

                if (css.equals("-")||css.equals("+")||css.equals("×")||css.equals("÷")||css.equals("%")) {
                    ToShowResult = true;
                    Log.d("LogHere", "Done");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "0");



                if(ToShowNow){
                    data = inputTxt.getText().toString();
                    data = data.replaceAll("×", "*");
                    data = data.replaceAll("%", "/100");
                    data = data.replaceAll("÷", "/");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String finalResult = "";
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, data, "javascript", 1, null).toString();

                    outputTxt.setText(finalResult);
                    String textString = outputTxt.getText().toString();
                    if (textString.length() > 0) {
                        outputTxt.setText(textString.substring(0, textString.length() - 2));
                    }
                }


            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
                FindResult();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "2");
                FindResult();
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "3");
                FindResult();
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "4");
                FindResult();
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "5");
                FindResult();
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "6");
                FindResult();
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "7");
                FindResult();
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "8");
                FindResult();
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "9");
                FindResult();
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + ".");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "-");
            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "%");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "×");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "÷");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
         FindResult();


            }
        });

        btn_del = findViewById(R.id.btn_del);
        if (btn_del != null) {
            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    String textString = inputTxt.getText().toString();
                    if (textString.length() > 0) {
                        inputTxt.setText(textString.substring(0, textString.length() - 1));
                    }



                    String CurntText=inputTxt.getText().toString();
                    String last=String.valueOf(CurntText.charAt(inputTxt.length() - 1)) ;

                    Log.d("LogHere",last);

                    if (last.equals("-")||last.equals("+")||last.equals("×")||last.equals("÷")||last.equals("%")) {
                        ToShowNow=false;
                        outputTxt.setText("");
                    }
                    else {
                        FindResult();
                    }
                    if (last.equals(0)){
                        outputTxt.setText("");
                    }




                }
            });
        }
    }
    
    public void FindResult (){
        if(ToShowNow) {
            data = inputTxt.getText().toString();

            data = data.replaceAll("×", "*");
            data = data.replaceAll("%", "/100");
            data = data.replaceAll("÷", "/");

            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);

            String finalResult = "";
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, data, "javascript", 1, null).toString();

            outputTxt.setText(finalResult);
            String textString = outputTxt.getText().toString();
            if (textString.length() > 0) {
                outputTxt.setText(textString.substring(0, textString.length() - 2));
            }
        }



    }
}