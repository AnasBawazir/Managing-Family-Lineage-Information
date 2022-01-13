import java.io.*;
import java.util.*;
class Tutorial
{
    String profileid,gender,is_alive,birth_year,birth_month,birth_day,birth_location_country,death_year,death_month,
            death_day,death_location_country;
    public static void main(String ar[]) {
        Tutorial t=new Tutorial();
String date="1/9/1997";
int state=1;
        t.search(date,state);
    }
    public void search(String date,int state) {
        try
        {
            //BufferedReader br=new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\profiles-anon.txt"));
            BufferedReader br=new BufferedReader(new FileReader("Database.txt"));

            String s;
            String[]dateSplit=date.split("/");
            while( (s=br.readLine()) !=null )
            {
                String data[]=new String[75];
                data=s.split("\t");
                            profileid = data[0];
                            gender = data[1];
                            is_alive=data[2];
                            birth_year = data[14];
                            birth_month=data[15];
                            birth_day=data[16];
                            birth_location_country=data[21];
                            death_year = data[29];
                            death_month = data[30];
                            death_day = data[31];
                            death_location_country = data[36];
                switch (state) {
                    case 0:
                        if (is_alive.equals("0") && death_day.equals(dateSplit[0]) && death_month.equals(dateSplit[1]) && death_year.equals(dateSplit[2])) {
                            System.out.println(profileid + "\t" + gender);
                        }
                        break;
                    case 1:
                        if (is_alive.equals("1") && birth_day.equals(dateSplit[0] )&& birth_month.equals(dateSplit[1]) && birth_year.equals(dateSplit[2])){
                            System.out.println(profileid + "\t" + gender);                            }
                        break;
                }

            }
        }
        catch(Exception e){}

    }


}