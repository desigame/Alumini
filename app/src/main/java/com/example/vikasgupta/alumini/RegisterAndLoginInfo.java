package com.example.vikasgupta.alumini;

import android.content.Context;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by Vikas Gupta on 7/21/2016.
 */
public class RegisterAndLoginInfo {

    public static void regiserInfoInFile(JnvAlumini alumini, Context context){
        try {
            FileOutputStream fos = context.openFileOutput("register_info.txt", Context.MODE_PRIVATE);
            fos.write(makeStringObject(alumini).getBytes());
            fos.close();
            //makeStrinObject(alumini);
           // writer.println(makeStringObject(alumini));
            Toast.makeText(context,"file saved", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(context,"file not saved ERROR!!!!", Toast.LENGTH_SHORT).show();
        }
    }
    static String makeStringObject(JnvAlumini alumini){
       // StringBuilder aluminiString;
        String aluminiString;
        aluminiString="name="+alumini.getName()+"pwd="+alumini.getPwd()+"isMale="+alumini.isMale()+"jnvName="+alumini.getJnvName()
                +"passYear="+alumini.getPassYear()+"email="+alumini.getEmail()+"mobNo="+alumini.getMobNo();

        return aluminiString;
    }
}
