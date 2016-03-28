package Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	
	public static int countSeconds = 0;

	public static void main(String[] args) {

		  final Timer time = new Timer();

	        time.schedule(new TimerTask() {
	            int i = 0;
	            @Override
	            public void run() { //оепегюцпсфюел лернд RUN б йнрнпнл декюере рн врн бюл мюдн
	                if(i>=20){
	                    System.out.println("рЮИЛЕП ГЮБЕПЬХК ЯБНЧ ПЮАНРС");
	                    time.cancel();
	                    return;
	                }
	                System.out.println(i);
	                i = i + 1;
	            }
	        },1, 1000); //(4000 - онднфдюрэ оепед мювюкнл б лхкхяей, онбрнпъряъ 4 яейсмдш (1 яей = 1000 лхкхяей))
	    }
}
