package com.mobiquity.atm.Util

class JsonProcessor {

    public static String processJson(String rawJson){
        String op='[{('
        int index=0;
        for(int i=0;i<rawJson.length();i++){
            if(op.contains(rawJson.charAt(i).toString())){
                index=i;
                break
            }

        }
        rawJson.substring(index)

    }
}
