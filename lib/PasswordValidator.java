package lib;

public class PasswordValidator {
     
    /**
     @param password ใส่รหัสผ่านเป็น ตัวอักษรพิมพ์เล็ก พิมใหญ่ ตัวเลข 8 ตัว
     @return ระดับความปลอดภัย
     **/
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        
        if ( password.length() < 8 ) {
            return PasswordStrength.INVALID;
        }

        boolean lower = false ;
        boolean upper = false ;
        boolean number = false ;

        for ( char c : password.toCharArray()){
            if( Character.isLowerCase(c))
                lower = true ;
            else if (Character.isUpperCase(c))
                upper = true ;
            else if (Character.isDigit(c))
                number = true;
        }
        
        if(lower && !upper ) return PasswordStrength.WEAK;

        if(lower && upper) return PasswordStrength.MEDIUM;
        
        if(lower && upper && number ) return PasswordStrength.STRONG;
        
        int minLength = 8; // TODO: มีอะไรขาดหายไปที่บรรทัดนี้?
        
        return PasswordStrength.INVALID ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}