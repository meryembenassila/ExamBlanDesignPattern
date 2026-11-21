package org.example.aspects;

public class SecurityContext {
    public static String username = "";
    public static String password = "";
    public static String[] roles={};

    public static void authenticate(String u , String p ,String[] r){
        if(u.equals("root") && p.equals("1234")){
            username = u;
            password = p;
            roles=r;
        }else{
            throw  new RuntimeException("Access Denied");
        }
    }

    public static boolean hasRole(String r) {
        for (String role : roles) {
            if (role.equals(r)) return true;
        }
        return false;
    }


}

