package javatest;

public class LoginServelet {
        private static String usernameRef;
        private static String passwordRef;
        public static void doPost(String username,String password){
            try{
                usernameRef = username;
                if(username.equals("a")){
                    Thread.sleep(1000);
                }
                passwordRef = password;
                System.out.println("username="+usernameRef+", passwors="+passwordRef);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
}
