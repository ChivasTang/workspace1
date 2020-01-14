package com.flyingStone;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static int PROCESS_NUMBER=15;

    public static void main(String[] args) {
        String fullPath="/Users/tsk/Desktop/workspace/flyingStone/src/main/resources/files/20190202.csv";

        List<TomDomain> tomList=readFile(fullPath);
        List<File> files=cufFiles(tomList,"20190202",PROCESS_NUMBER);
    }

    private static List<TomDomain> readFile(String filePath){
        File file=new File(filePath);
        List<TomDomain> tomList=new ArrayList<TomDomain>();
        BufferedReader br = null;
        try{
            br=new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        String everyLine = "";
        try{
            while((line = br.readLine()) != null){
                everyLine=line;
                List<String> oneLine= Arrays.asList(everyLine.split(" "));
                TomDomain tom=new TomDomain();
                for(String str:oneLine){
                    tom.setHtcNum(oneLine.get(0));
                    tom.setMotoNo(oneLine.get(1));
                    tom.setMotoCustNo(oneLine.get(2));
                    tom.setGenNo(oneLine.get(3));
                    tom.setGenCustNo(oneLine.get(4));
                }
                tomList.add(tom);
                System.out.println(everyLine);
            }
            System.out.println("csv表格中所有行数：" + tomList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tomList;
    }


    private static List<File> cufFiles(List<TomDomain> tomList, String fileNamePrefix, int processNumber){
        List<File> files=new ArrayList<>();

        int total=tomList.size();
        int mod=total%processNumber;
        int minNum=(total-mod)/processNumber;
        int maxNum=minNum+mod;

        for(int i=0;i<processNumber;i++){
            if(i==0){
                List<TomDomain> tomList0=tomList.subList(0,minNum-1);
                List<String> listString=getStringListFromDomain(tomList0);
                File file=createFile(listString,fileNamePrefix,i);
                files.add(file);
            }else if(i>1 && i==processNumber-1){
                List<TomDomain> tomListL=tomList.subList(minNum*i,total-1);
                List<String> listString=getStringListFromDomain(tomListL);
                File file=createFile(listString,fileNamePrefix,i);
                files.add(file);
            }else{
                List<TomDomain> tomListI=tomList.subList(minNum*i,minNum*(i+1)-1);
                List<String> listString=getStringListFromDomain(tomListI);
                File file=createFile(listString,fileNamePrefix,i);
                files.add(file);
            }
        }

        return files;
    }

    private static List<String> getStringListFromDomain(List<TomDomain> tomList){
        List<String> lineStringList=new ArrayList<>();
        for(TomDomain tom: tomList){
            String line=tom.getHtcNum()+" "+tom.getMotoNo()+" "+tom.getMotoCustNo()+" "+tom.getGenNo()+" "+tom.getGenCustNo();
            lineStringList.add(line);
        }
        return lineStringList;
    }

    private static File createFile(List<String> data,String fileNamePrefix,int j){
        String parentPath="/Users/tsk/Desktop/workspace/flyingStone/src/main/resources/files";
        String fileFllPath=parentPath+File.separator+fileNamePrefix+"_"+System.currentTimeMillis()+"_"+j+".csv";
        File file=new File(fileFllPath);
        try{
            OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(fileFllPath),"UTF-8");
            for(String line:data){
                ow.write(line);
                ow.write("\r\n");
            }
            ow.flush();
            ow.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(fileFllPath);
    }

}
