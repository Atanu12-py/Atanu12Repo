package org.example;
import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws IOException {
        String myurl="https://api.nationalize.io/?name=nathaniel";
        HttpURLConnection connection=null;
        int responceCode=0;
        URL url=null;
        try {
            url=new URL(myurl);
        }
        catch (MalformedURLException e){
            System.out.println("Something is wrong");
        }
        try {
            connection=(HttpURLConnection)url.openConnection();
            responceCode=connection.getResponseCode();
        }
        catch (IOException e){
            throw new RuntimeException();
        }
        if(responceCode==200){
                BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder apidata=new StringBuilder();
                String readline=null;
                while ((readline=in.readLine())!=null){
                    apidata.append(readline);
                }
                try {
                    in.close();
                }
                catch (IOException e){
                    throw new RuntimeException();
                }
                System.out.println(apidata);
                JSONObject jsonapi=new JSONObject(apidata.toString());
        }
        else{
            System.out.println("Api call isnot successful");
        }
        }
    }
