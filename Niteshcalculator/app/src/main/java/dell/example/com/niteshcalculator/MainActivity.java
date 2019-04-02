package dell.example.com.niteshcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }

    TextView txtCalculations;
    TextView txtResults;
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private OPERATOR oprInput;
    private double calcutionResuls;
    private String calcutionsString;
    private double check;
    private int opr;
    private int numberTyped;
    private int dotTapped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber="";
        calcutionsString="";
        calcutionResuls=0;
        check=2.0;
        opr=0;
        stringNumberAtLeft="";
        numberTyped=0;
        dotTapped=0;


        txtCalculations= findViewById(R.id.txtcalculations);
        txtResults=findViewById(R.id.txtResults);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndot).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                opr=0;
                dotTapped=0;

                break;
            case R.id.btn7:
                if(oprInput==OPERATOR.SUBTRACT)
                {   numberIsTapped("-7");
                oprInput=null;
                }
                else
                numberIsTapped("7");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn8:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-8");
                    oprInput=null;
                }
                else
                numberIsTapped("8");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn9:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-9");
                    oprInput=null;
                }
                else
                numberIsTapped("9");
                numberTyped++;
                opr=0;
                break;
            case R.id.btnPlus:
                if(numberTyped!=0)
                {
                opr++;
                if(opr==1)
                operatorIsTapped(OPERATOR.PLUS);
                calcutionsString=calcutionsString+" + ";
                dotTapped=0;
                }
                break;
            case R.id.btn4:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-4");
                    oprInput=null;
                }
                else
                numberIsTapped("4");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn5:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-5");
                    oprInput=null;
                }
                else
                numberIsTapped("5");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn6:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-6");
                    oprInput=null;
                }
                else
                numberIsTapped("6");
                numberTyped++;
                opr=0;
                break;
            case R.id.btnMinus:
                opr++;
                if(opr==1&&numberTyped!=0)
                operatorIsTapped(OPERATOR.SUBTRACT);
                else
                { oprInput=OPERATOR.SUBTRACT;
                opr=0;
                }
                dotTapped=0;
                calcutionsString=calcutionsString+" - ";
                break;
            case R.id.btn1:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-1");
                    oprInput=null;
                }
                else
                numberIsTapped("1");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn2:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-2");
                    oprInput=null;
                }
                else
                numberIsTapped("2");
                numberTyped++;
                opr=0;
                break;
            case R.id.btn3:
                if(oprInput==OPERATOR.SUBTRACT)
                {
                    numberIsTapped("-3");
                    oprInput=null;
                }
                else
                numberIsTapped("3");
                numberTyped++;
                opr=0;
                break;
            case R.id.btnMultiply:
                if(numberTyped!=0){
                opr++;
                if(opr==1)
                operatorIsTapped(OPERATOR.MULTIPLY);
                calcutionsString=calcutionsString+" * ";
                dotTapped=0;
                }


                break;
            case R.id.btnClear:
                clearTapped();
                opr=0;
                numberTyped=0;
                break;
            case R.id.btndot:
                if(dotTapped==0)
                {
                    numberIsTapped(".");
                    numberTyped++;
                }
                dotTapped++;

                break;
            case R.id.btn0:
                numberIsTapped("0");
                numberTyped++;
                opr=0;
                break;
            case R.id.btnDivide:
                if(numberTyped!=0) {
                    opr++;
                    if (opr == 1)
                        operatorIsTapped(OPERATOR.DIVIDE);

                    calcutionsString = calcutionsString + " / ";
                    dotTapped=0;
                }
                break;
        }
        txtCalculations.setText(calcutionsString);


    }
    private void numberIsTapped(String tappedNumber)
    {
        currentNumber=currentNumber+tappedNumber;
        txtResults.setText(currentNumber);
        calcutionsString=currentNumber;
        txtCalculations.setText(calcutionsString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator)
    {
        if(currentOperator!=null)
        {
            if(currentNumber!="")
               {

                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calcutionResuls = Double.parseDouble(stringNumberAtLeft) + Double.parseDouble(stringNumberAtRight);

                        break;
                    case SUBTRACT:

                        calcutionResuls = Double.parseDouble(stringNumberAtLeft) - Double.parseDouble(stringNumberAtRight);

                        break;

                    case MULTIPLY:
                        calcutionResuls = Double.parseDouble(stringNumberAtLeft) * Double.parseDouble(stringNumberAtRight);

                        break;
                    case DIVIDE:
                        check=Double.parseDouble(stringNumberAtRight);
                        if(check!=0.0)
                            calcutionResuls = Double.parseDouble(stringNumberAtLeft) / Double.parseDouble(stringNumberAtRight);
                        else
                            txtResults.setText("Ans= Infinity \nerror can occur in next Operations");
                        break;
                        default:opr=0;
                        oprInput=null;

                }
                if(check!=0.0){
                stringNumberAtLeft = String.valueOf(calcutionResuls);
                txtResults.setText("Ans= "+stringNumberAtLeft);
                calcutionsString = stringNumberAtLeft;
               }
            }
        }else
        {
            stringNumberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=tappedOperator;
    }
    private void clearTapped()
    {
        stringNumberAtRight="";
        stringNumberAtLeft="";
        calcutionResuls=0;
        currentNumber="";
        currentOperator=null;
        txtResults.setText("0");
        calcutionsString="";
        txtCalculations.setText("0");
        check=2;
        dotTapped=0;
    }
}
