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
