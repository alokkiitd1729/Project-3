

/**
 * Project completion Date 18 November 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project 3
 *     and Visit under the section under the name of this class.
 */


import java.util.*;
public class User {
String uid;	
MySet<usertimepair> followers=new MySet<usertimepair>();
MySet<usertimepair> follows=new MySet<usertimepair>();
Vector<Message> screen = new Vector<Message>(); // for seeing other published messages
Vector<Message> hissetofmessages = new Vector<Message>();// his own publishes message
// connector for user
User(String s){
	uid=s;
}

}
