

/**
 * Project completion Date 18 November 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project1
 *     and Visit under the section under the name of this class.
 */


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
