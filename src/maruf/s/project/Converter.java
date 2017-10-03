 
package maruf.s.project;

import java.math.BigInteger;

 
   class Converter {
       
       private String retValue;
    public String Convert(String inputType, String inputValue, String outputType){
        
        
        retValue = new String();
         
        
        if(outputType.equalsIgnoreCase("Decimal"))
        {
            if(inputType.equalsIgnoreCase("Binary")){
                return BinToDec(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Octal")){
                return OctToDec(inputValue);
            }
           
            else  if(inputType.equalsIgnoreCase("Hexadecimal")){
                return HexToDec(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("BCD")){
                return BCDToDec(inputValue);
            }
        }
        
        else if(outputType.equalsIgnoreCase("Binary"))
        {
            if(inputType.equalsIgnoreCase("Decimal")){
                return DecToBin(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Octal")){
                return OctToBin(inputValue);
            }
           
            else  if(inputType.equalsIgnoreCase("Hexadecimal")){
                return HexToBin(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("BCD")){
                return BCDToBin(inputValue);
            }
            
            
        }
            
            
        else if(outputType.equalsIgnoreCase("Octal"))
        {
            
            if(inputType.equalsIgnoreCase("Binary")){
                return BinToOct(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Decimal")){
                return DecToOct(inputValue);
            }
           
            else  if(inputType.equalsIgnoreCase("Hexadecimal")){
                return HexToOct(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("BCD")){
                return BCDToOct(inputValue);
            }
        }
            
            
        else if(outputType.equalsIgnoreCase("Hexadecimal"))
        {
            if(inputType.equalsIgnoreCase("Binary")){
                return BinToHex(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Octal")){
                return OctToHex(inputValue);
            }
           
            else  if(inputType.equalsIgnoreCase("Decimal")){
                return DecToHex(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("BCD")){
                return BCDToHex(inputValue);
            }
        }
            
            
        else if(outputType.equalsIgnoreCase("BCD"))
        {
            if(inputType.equalsIgnoreCase("Binary")){
                return BinToBCD(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Octal")){
                return OctToBCD(inputValue);
            }
           
            else  if(inputType.equalsIgnoreCase("Hexadecimal")){
                return HexToBCD(inputValue);
            }
            
            else  if(inputType.equalsIgnoreCase("Decimal")){
                return DecToBCD(inputValue);
            }
        }
        
        
        return retValue;
    }
    
    
    
    public String BinToDec(String inputValue){
       retValue = new String();
       
      retValue = Integer.toString(Integer.parseInt(inputValue,2));
       return retValue;
    }
    
     
    public String BinToOct(String inputValue){
        retValue = new String();
        
        
        retValue = Integer.toOctalString(Integer.parseInt(inputValue,2));
        
        
        return retValue;
    }
    
    
    public String BinToHex(String inputValue){
        retValue = new String();
        
        retValue = Integer.toHexString(Integer.parseInt(inputValue,2));
        
        return retValue; 
    } 
    
    
     
    public String BinToBCD(String inputValue){
        
        int i, len;
        retValue = new String();
        retValue = BinToDec(inputValue);
        retValue = DecToBCD(retValue);
         
        return retValue; 
    }
    
    public String DecToBin(String inputValue){
        retValue = new String();
       retValue = Integer.toBinaryString(Integer.parseInt(inputValue));  
       return retValue;
    }
    
     
    public String OctToBin(String inputValue){
         retValue = new String();
        
        retValue = Integer.toBinaryString(Integer.parseInt(inputValue,8));
        
        return retValue;
    }
    
    
    
    public String HexToBin(String inputValue){
        retValue = new String();
        
        retValue = Integer.toBinaryString(Integer.parseInt(inputValue,16));
        
        return retValue;
    } 
    
    
    public String BCDToBin(String inputValue){
        
        retValue = new String();
        retValue = BCDToDec(inputValue);
        retValue = DecToBin(retValue);
        
        return retValue;
    }
    
    public String DecToOct(String inputValue){
       retValue = new String();
        
        retValue = Integer.toOctalString(Integer.parseInt(inputValue));
        
        return retValue; 
    }
    
    public String DecToHex(String inputValue){
         retValue = new String();
        
        retValue = Integer.toHexString(Integer.parseInt(inputValue));
        
        return retValue; 
    }
    
    
    public String DecToBCD(String inputValue){
       int i, len;
        retValue = new String();
        String intString = new String();
        String[] bcdCode = new String[12];
        
        
        bcdCode[0]="0000";
         bcdCode[1]="0001";
          bcdCode[2]="0010";
         bcdCode[3]="0011";
          bcdCode[4]="0100";
         bcdCode[5]="0101";
          bcdCode[6]="0110";
         bcdCode[7]="0111";
          bcdCode[8]="1000";
          bcdCode[9]="1001";
        
        intString = inputValue;
        
       len = intString.length();
       for(i=0; i<len; i++){
           retValue += bcdCode[intString.charAt(i) - 48];
       }
        return retValue; 
    }
    
     public String OctToDec(String inputValue){
         retValue = new String();
       
          retValue = Integer.toString(Integer.parseInt(inputValue,8));
      
        
           return retValue;
    }
     
    public String HexToDec(String inputValue){
         retValue = new String();
       
      retValue = Integer.toString(Integer.parseInt(inputValue,16));
      
       return retValue;
    }
    
    
    public String BCDToDec(String inputValue){
     int len, i, j, temp, mul;
     retValue = new String();
        
     len = inputValue.length();
        
      for(i=0; i<len; i+=4)
      {
          j=i+3;
          temp=0;
          mul=1;
          while(j>=i && j<len)
          {
            temp = temp+(inputValue.charAt(j)-48)*mul;
            mul *= 2;
            j--;
          }
          retValue += Integer.toString(temp);
          
      }
        return retValue;  
        
    }
    
    
    public String OctToHex(String inputValue){
         retValue = new String();
        
        retValue = Integer.toHexString(Integer.parseInt(inputValue,8));
        
        return retValue; 
    }
    
    public String OctToBCD(String inputValue){
        int i, len;
        retValue = new String();
        retValue = OctToDec(inputValue);
        retValue = DecToBCD(retValue);
         
        return retValue; 
    }
    public String HexToOct(String inputValue){
        retValue = new String();
        
        retValue = Integer.toOctalString(Integer.parseInt(inputValue,16));
        
        return retValue; 
    }
    
    public String BCDToOct(String inputValue){
        retValue = new String();
        retValue = BCDToDec(inputValue);
        retValue = DecToOct(retValue);
        
        return retValue;
    } 
    
    public String HexToBCD(String inputValue){
        int i, len;
        retValue = new String();
        retValue = HexToDec(inputValue);
        retValue = DecToBCD(retValue);
         
        return retValue; 
    }
    
    public String BCDToHex(String inputValue){
       retValue = new String();
        retValue = BCDToDec(inputValue);
        retValue = DecToHex(retValue);
        
        return retValue; 
    }
    
    
}
