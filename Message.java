public class Message {
int time;
String uid,tid,ptid,typeofmessage,text;

//3rd constructor for REPLY type message
Message(int time1,String uid1,String type1,String ptid1,String text1,String tid1){
   
    	time=time1;
    	uid=uid1;
    	typeofmessage=type1;
    	ptid=ptid1;
    	text=text1;
    	tid=tid1;
    
}
}
