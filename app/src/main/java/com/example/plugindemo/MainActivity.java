package com.example.plugindemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime = System.currentTimeMillis();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        if(costTime > 100){
            StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[0];//获得当前方法的StackTraceElement
            Log.e("TimeCost", String.format(
                    "===> %s.%s(%s:%s)方法耗时 %d ms",
                    thisMethodStack.getClassName(), //类的全限定名称
                    thisMethodStack.getMethodName(),//方法名
                    thisMethodStack.getFileName(),  //类文件名称
                    thisMethodStack.getLineNumber(),//行号
                    costTime                        //方法耗时
                    )
            );
        }
    }

    private static void method1(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method2(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void method3(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}