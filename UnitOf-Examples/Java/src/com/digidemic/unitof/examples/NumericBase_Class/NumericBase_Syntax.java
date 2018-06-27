/**
 * https://github.com/Digidemic/UnitOf
 * (c) 2018 DIGIDEMIC, LLC - All Rights Reserved
 * UnitOf developed by Adam Steinberg of DIGIDEMIC, LLC
 * License: Apache License 2.0
 *
 * ====
 *
 * Copyright 2018 DIGIDEMIC, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.digidemic.unitof.examples.NumericBase_Class;

import com.digidemic.unitof.UnitOf;

/**
 * Numeric Base converts the same ways as the normal conventional measurements but with 3 small differences.
 * 1. All "To" conversions MUST be wrapped with a try/catch. This is due to many conversions having letters passed in that may not apply to other base units.
 * 2. Rather than just numbers, in most cases a String will need to be passed in as many base units use letters (these do not have to be case sensitive).
 * 3. Rather than type double being returned, a String is always returned.
 */
public class NumericBase_Syntax {
    
    public static void oneLiner_1_Step(){
        p("\n-=-=-=-=-=-=-=-=-\nNumericBase Syntax: 1 step conversion|One Liner, ADa3 hex to binary");
        
        String hexToBinary = "";    //Conversion variable
        try{
            hexToBinary = new UnitOf.NumericBase().fromHexadecimal("ADa3").toBinary();  //Takes "ADa3" hexidecimal and convert it into Binary, returns "1010110110100011"
        } catch(Exception e){
            //Handle exception: all NumericBase conversion "To" are throwable. This is due to many conversions having letters passed in that may not apply to other base units.
        }
        
        pt(hexToBinary);    //Prints "1010110110100011"
    }  
    
    public static void setThenConvert_2_Steps(){
        p("\n-=-=-=-=-=-=-=-=-\nNumericBase Syntax: 2 step conversion|set then convert, ADa3 Hex to binary and decimal");
        
        String binary = "";     //Conversion variable
        String decimal = "";    //Conversion variable
        UnitOf.NumericBase hex = new UnitOf.NumericBase().fromHexadecimal("-ADa3");  //Instantiate UnitOf.NumericBase hex and set "hexadecimal" variable as "-ADa3" hexadecimal (not case sensitive)
        try{
            binary = hex.toBinary();    //Returns "-1010110110100011"
            decimal = hex.toDecimal();  //Returns "-44451"
        } catch(Exception e){
            //Handle exception: all NumericBase conversion "To" are throwable. This is due to many conversions having letters passed in that may not apply to other base units.
        }
        
        pt(binary);     //Prints "-1010110110100011"
        pt(decimal);    //Prints "-44451"
    }    
    
    public static void instantiateSetThenConvert_3_Steps(){
        p("\n-=-=-=-=-=-=-=-=-\nNumericBase Syntax: 3 step conversion|instantiate,set, then convert, 3239 decimal to binary and hex");
        
        String binary = "";     //Conversion variable
        String hex = "";        //Conversion variable
        UnitOf.NumericBase nb = new UnitOf.NumericBase();   //Instantiate UnitOf.NumericBase nb 
        nb.fromDecimal(3239);   //Sets nb as 3239 decimal
        try{
            binary = nb.toBinary();     //Returns "110010100111"
            hex = nb.toHexadecimal();   //Returns "CA7"
        } catch(Exception e){
            //Handle exception: all NumericBase conversion "To" are throwable. This is due to many conversions having letters passed in that may not apply to other base units.
        }
        
        pt(binary); //Prints "110010100111"
        pt(hex);    //Prints "CA7"
    } 
    
    public static void getFromTypeAndValue(){
        p("\n-=-=-=-=-=-=-=-=-\nNumericBase Syntax: Get the passed in from type constant and value");

        UnitOf.NumericBase nb = new UnitOf.NumericBase().fromHexadecimal("ADa3");   //Instantiate UnitOf.NumericBase nb and set "hexadecimal" variable as "ADa3" hexadecimal (not case sensitive)
        String fromType = nb.getTypeConstantPassed();   //Returns "B16"
        Object fromVal = nb.getValuePassed();           //Returns "ADa3"
        
        pt(fromType);   //Prints "B16"
        pt(fromVal);    //Prints "ADa3"
    } 
    
    public static void illegalArgumentException(){
        p("\n-=-=-=-=-=-=-=-=-\nNumericBase Syntax: Intentional error thrown when invalid value is passed to the from type");
       
        UnitOf.NumericBase iShouldBeBase3ButAmBinary = new UnitOf.NumericBase().fromBinary("012");  //Instantiate UnitOf.NumericBase iShouldBeBase3ButAmBinary and set "binary" variable as "012" binary (not case sensitive)    
        String decimal;     //Conversion variable
        try{
            decimal = iShouldBeBase3ButAmBinary.toDecimal();    //Tries to convert to decimal but fails.
        } catch(Exception e){   //Handle exception: all NumericBase conversion "To" are throwable. This is due to many conversions having letters passed in that may not apply to other base units.
            decimal = "Intentional error for the example was thrown with the following message: " + e.getMessage();
        }
        
        pt(decimal);    //Prints the error message since Binary only allows 0 and 1 to be passed as its value. The value of "012" exceeds binary's allowed characters
    }
    
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Print object passed, starting with a tab
    private static void pt(Object o){
        p("\t" + o);
    }

    //Print object passed
    private static void p(Object o){
        System.out.println(String.valueOf(o));
    }
    
}
