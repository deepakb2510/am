package com.android.attendance.activity;

import android.content.Intent;
import android.graphics.Color;
import android.security.keystore.StrongBoxUnavailableException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.AttendanceSessionBean;
import com.android.attendance.bean.FacultyBean;
import com.android.attendance.bean.StudentBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

import java.util.ArrayList;

public class StudentAttendence extends AppCompatActivity {
    Spinner spinnersubject;
    Button submit;
    int Studentid;
    String sclass;
    String Subject;
    String studentclass;
    TextView displayResult;

    private String[] branchString = new String[] {"IT"};
    private String[] yearString = new String[] {"SE","TE","BE"};
    private String[] subjectSEString = new String[] {"DSA","DBMS"};
    private String[] subjectTEString = new String[] {"CNS","IP"};
    private String[] subjectBEString = new String[] {"AI","END"};
    private String[] subjectFinal = new String[]{"Select Subject"};
    ArrayAdapter<String> adapter_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence);
        spinnersubject=(Spinner)findViewById(R.id.spinneryearView2);
        submit=(Button)findViewById(R.id.submitButton2);
        displayResult = findViewById(R.id.textView6);

        AttendanceSessionBean attendanceSessionBean = new AttendanceSessionBean();
        StudentBean bean=((ApplicationContext)StudentAttendence.this.getApplicationContext()).getStudentBean();
        Studentid=bean.getStudent_id();
        final DBAdapter dbAdapter = new DBAdapter(StudentAttendence.this);
        studentclass=bean.getStudent_class();
        Log.d("studentclass",""+studentclass);
        Log.d("StudentID", ""+Studentid);


        if(studentclass.equals("SE"))
                {
                    subjectFinal = subjectSEString;
                    adapter_subject = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjectFinal);
                    adapter_subject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnersubject.setAdapter(adapter_subject);
                    Log.d("SubjectStringSE",""+subjectFinal[1]);
                }
                else if(studentclass.equals("TE"))
                {
                    subjectFinal = subjectTEString;
                    adapter_subject = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjectFinal);
                    adapter_subject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnersubject.setAdapter(adapter_subject);
                    Log.d("SubjectStringTE",""+subjectFinal[1]);
                }
                else if(studentclass.equals("BE"))
                {
                    subjectFinal = subjectBEString;
                    adapter_subject = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjectFinal);
                    adapter_subject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnersubject.setAdapter(adapter_subject);
                    Log.d("SubjectStringBE",""+subjectFinal[1]);
                }
        spinnersubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                Log.d("Spinner3",""+subjectFinal[0]);
                Subject =(String) spinnersubject.getSelectedItem();
                Log.d("Subject",""+Subject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String total=dbAdapter.StudentAttendance(String.valueOf(Studentid),String.valueOf(Subject));
                String present=dbAdapter.StudentPresentAttendance(String.valueOf(Studentid),String.valueOf(Subject));
                String resultText = "Total Attendance Result:"+total+"\n Total Present: "+present;
                displayResult.setText(resultText);







//                startActivity(intent);
            }
        });
    }
}