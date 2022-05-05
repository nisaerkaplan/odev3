package odev3;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
       get("/", (req, res) -> "Hello, World");

       get("/compute",
       (rq, rs) -> {
       Map<String, String> map = new HashMap<String, String>();
       map.put("result", "not computed yet!");
       return new ModelAndView(map, "compute.mustache");
       },
       new MustacheTemplateEngine());

       post("/compute", (req, res) -> {
        
           String input1 = req.queryParams("input1");
           java.util.Scanner sc1 = new java.util.Scanner(input1);
           sc1.useDelimiter("[;\r\n]+");
           int[] inputList = new int[5];
           while (sc1.hasNext())
           {
          for(int i=0 ; i<inputList.length; i++){
            inputList[i]= Integer.parseInt(sc1.next().replaceAll("\\s",""));;
          }
           }
           sc1.close();

           String input2 = req.queryParams("input2").replaceAll("\\s","");
           int input2AsInt = Integer.parseInt(input2);
           boolean result = App.ToplamaIslemi(inputList, input2AsInt);
           Map<String, Boolean> map = new HashMap<String, Boolean>();
           map.put("result", result);
           return new ModelAndView(map, "compute.mustache");
           }, 
           new MustacheTemplateEngine());

           get("/compute",
           (rq, rs) -> {
           Map<String, String> map = new HashMap<String, String>();
           map.put("result", "not computed yet!");
           return new ModelAndView(map, "compute.mustache");
           },
           new MustacheTemplateEngine());
   }

   public static boolean ToplamaIslemi(int array[],int e)
   {
       System.out.println("dizi"+Arrays.toString(array));
       int toplam = 0;
    
   if(array==null) return false;
   for(int elt:array){
      toplam = toplam+elt;
   } 
   System.out.println("toplam"+toplam);
   if(toplam == e) return true;
     else  return false;      
    
   }
    }