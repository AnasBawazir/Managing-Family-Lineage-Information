import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Family {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("█───█─▄▀▀─█───▄▀▀─▄▀▀▄─█▄─▄█─▄▀▀\n" +
                "█───█─█───█───█───█──█─█▀▄▀█─█──\n" +
                "█───█─█▀▀─█───█───█──█─█─▀─█─█▀▀\n" +
                "█▄█▄█─█───█───█───█──█─█───█─█──\n" +
                "─▀─▀───▀▀──▀▀──▀▀──▀▀──▀───▀──▀▀");
        System.out.println("choose a service \n" + "1- Finding Siblings\n" + "2- All ancestor/decedents\n"
                + "3- Display all Cousins\n"
                + "4- People died/born on a specific date, Country\n"
                + "insert the number of service ");
        int service = Integer.parseInt(scan.nextLine());
        if (service==1){
            System.out.println("hi 1");
            System.out.println("you want to find \n" + "1- brothers \n" + "2- sisters \n");
            int sibling = Integer.parseInt(scan.nextLine());
            if (sibling==1){
                System.out.println("search about brothers\n enter the person ID ");
                String personID=scan.nextLine();
                displayBrothers(personID);

            }
        }
        else if (service==2){
            System.out.println("hi 2");
            System.out.println("you want to find \n"
                    + "1- parent \n"
                    + "2- children \n");
            int ancestor = Integer.parseInt(scan.nextLine());
            if (ancestor==1){
                //ابحث عن الاباء
                System.out.println("search about parent");

            }
            else if (ancestor==2){
                // ابحث عن الابناء
                System.out.println("search about children");
            }

        }
        else if (service==3){
            System.out.println("hi 3");

        }
        else if (service==4){
            System.out.println("hi 4");
            System.out.println("1.People born on specific date\n2.People born on specific Country\n3.People died on specific date" +
                    "\n4.People died on specific Country\ninsert what want to search about : ");
            int searchAbout = Integer.parseInt(scan.nextLine());
            switch (searchAbout){
                case 1:
                    System.out.println("enter the date day/month/year");
                    String dateB=scan.nextLine();
                    searchByDate(dateB,1);
                    break;
                case 2:
                    System.out.println("enter the Country :");
                    String countryB = scan.nextLine();
                    searchByPlace(countryB,1);
                    break;
                case 3:
                    System.out.println("enter the date day/month/year");
                    String dateD=scan.nextLine();
                    searchByDate(dateD,0);
                    break;
                case 4:
                    System.out.println("enter the Country :");
                    String countryD=scan.nextLine();
                    searchByPlace(countryD,0);
                    break;
            }

        }
    }
    public static void searchByDate(String date,int state) {
        String profileid,gender,is_alive,birth_year,birth_month,birth_day,death_year,death_month, death_day;
        try
        {
            BufferedReader br=new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\profiles-anon.txt"));
            //BufferedReader br=new BufferedReader(new FileReader("Database.txt"));
            String s;
            String[]dateSplit=date.split("/");
            System.out.println("Searching by date...");
            while( (s=br.readLine()) !=null )
            {
                String data [] = new String[75];
                data=s.split("\t");
                profileid = data[0];
                gender = data[1];
                is_alive=data[2];
                birth_year = data[14];
                birth_month=data[15];
                birth_day=data[16];
                death_year = data[29];
                death_month = data[30];
                death_day = data[31];
                switch (state) {
                    case 0://search for death
                        if ( death_day.equals(dateSplit[0]) && death_month.equals(dateSplit[1]) && death_year.equals(dateSplit[2])) {
                            System.out.println(profileid + "\t" + gender + "\tIs alive " + is_alive);
                        }
                        break;
                    case 1://search for born
                        if ( birth_day.equals(dateSplit[0] )&& birth_month.equals(dateSplit[1]) && birth_year.equals(dateSplit[2])){
                            System.out.println(profileid + "\t" + gender + "\tIs alive " + is_alive);                            }
                        break;
                }
            }
        }
        catch(Exception e){}
    }
    public static void searchByPlace(String place,int state) {
        String profileid,gender,is_alive,birth_location_country,death_location_country;

        try
        {
            BufferedReader br=new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\profiles-anon.txt"));
            //BufferedReader br=new BufferedReader(new FileReader("Database.txt"));
            String s;
            while( (s=br.readLine()) !=null )
            {
                String data[]=new String[75];
                data=s.split("\t");
                profileid = data[0];
                gender = data[1];
                is_alive=data[2];
                birth_location_country = data[21];
                death_location_country = data[36];
                switch (state) {
                    case 0:
                        if (death_location_country.equalsIgnoreCase(place)) {
                            System.out.println(profileid + "\t" + gender+ "\tIs alive " + is_alive);
                        }
                        break;
                    case 1:
                        if (birth_location_country.equalsIgnoreCase(place)){
                            System.out.println(profileid + "\t" + gender + "\tIs alive " + is_alive);                            }
                        break;
                }
            }
        }
        catch(Exception e){}

    }
    public static void displayBrothers(String person) {
        String parent,child,check;
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\relations-anon.txt"));
            BufferedReader nw = new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\relations-anon.txt"));

            String s,d;
            while ((s = br.readLine()) != null) {
                String data[] = new String[2];
                data = s.split("\t");
                parent = data[0];
                child = data[1];
                if (person.equalsIgnoreCase(child)) {
                    System.out.println("Brothers of " + child + " are ");
                    while ((d = nw.readLine()) != null ) {
                        String dataBro[] = new String[2];
                        dataBro = d.split("\t");
                        if (parent.equalsIgnoreCase(dataBro[0]))//compare same parent
                        {
                            System.out.println(dataBro[1]);
                        }
                    }
                }
            }
        }
        catch(Exception e){
        }
    }


}

