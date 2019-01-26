

/**
 * Project completion Date 18 November 2018
 *    Author@_Alok_Kumar
 *    Indian Institute of Technology(IIT) Delhi
 *
 *    To Understand the project in enough detail please go to ReadMe file of Project 3
 *     and Visit under the section under the name of this class.
 */


public class SocialMediaSite {
	MyHashTable<String,User> setofallusers = new MyHashTable<String,User>();// here string is UID
	MyHashTable<String,Message> setofallmessages = new MyHashTable<String,Message>(); // here string is TID	
	//given a ptid return a message type object	
	
	// methods for subscribe/unsubscribe/read/publish all type of messages
	public  void publishnew(int time1,String uid1,String type1,String text1,String tid1) {
		Message m = new Message(time1,uid1,type1,"",text1,tid1);
		setofallmessages.Insert(tid1,m);
		if(setofallusers.get(uid1)==null) {
			System.out.println("User with uid "+uid1+"doesn't exist");
		}
		User u= setofallusers.get(uid1);
		for(int i=0;i<u.followers.length();i++) {
			if(u.followers.ithelement(i).time<=time1 && u.followers.ithelement(i).subscription.equals("SUBSCRIBE")) {
				//System.out.println(u.followers.ithelement(i).uid);
				User u1= setofallusers.get(u.followers.ithelement(i).uid);
				u1.screen.add(m);
				//System.out.println(m.text);
			}
		}
		u.hissetofmessages.add(m);
	}
	public String publishrepost(int time1,String uid1,String type1,String ptid,String tid1) {
		if(setofallmessages.get(ptid)==null) {
			return ("No text with ptid "+ptid);
		}
		else if(setofallmessages.get(tid1)!=null) {
			return ("Can't publish with tid "+tid1);
		}
		else {
			if(setofallusers.get(uid1)==null) {
			System.out.println("User with uid "+uid1+"doesn't exist");
		}
			User u= setofallusers.get(uid1);
			Message m1 = setofallmessages.get(ptid);
			Message m2 = new Message(time1,uid1,type1,ptid,m1.text,tid1);
			setofallmessages.Insert(tid1,m2);
			for(int i=0;i<u.followers.length();i++) {
				if(u.followers.ithelement(i).time<time1 && u.followers.ithelement(i).subscription.equals("SUBSCRIBE")) {
					User u1= setofallusers.get(u.followers.ithelement(i).uid);
					u1.screen.add(m2);
				}
			}
			u.hissetofmessages.add(m2);
			return "";
		}
	}
	public String publishreply(int time1,String uid1,String type1,String ptid1,String text1,String tid1) {
		/*for(int j=0;j<setofallmessages.size();j++) {
			System.out.println(setofallmessages);
		}*/
		if(setofallmessages.get(ptid1)==null) {
			return ("No text with ptid "+ptid1);
		}
		else if(setofallmessages.get(tid1)!=null) {
			return ("Can't publish with tid "+tid1);
		}
		else {
			if(setofallusers.get(uid1)==null) {
			System.out.println("User with uid "+uid1+"doesn't exist");
		}
			Message m = new Message(time1,uid1,type1,ptid1,text1,tid1);
			setofallmessages.Insert(tid1,m);
			User u= setofallusers.get(uid1);
			for(int i=0;i<u.followers.length();i++) {
				if(u.followers.ithelement(i).time<time1 && u.followers.ithelement(i).subscription.equals("SUBSCRIBE")) {
					User u1= setofallusers.get(u.followers.ithelement(i).uid);
					u1.screen.add(m);
				}
			}
			u.hissetofmessages.add(m);
			return "";
		}
	}
	public void Subscribe(int time1,String uid1,String pid) {
		if(setofallusers.IsMember(pid)==false) {
			User u=new User(pid);
			setofallusers.Insert(pid,u);
		}
		if(setofallusers.IsMember(uid1)==false) {
			User u1=new User(uid1);
			setofallusers.Insert(uid1,u1);
		}
		boolean b1=false;
		boolean b2=false;
		for(int i=0;i<setofallusers.get(uid1).follows.length();i++) {
			if(setofallusers.get(uid1).follows.ithelement(i).uid.equals(pid)) {
				b2=true;
				setofallusers.get(uid1).follows.ithelement(i).time=time1;
				setofallusers.get(uid1).follows.ithelement(i).subscription="SUBSCRIBE";
			}
		}
		for(int i=0;i<setofallusers.get(pid).followers.length();i++) {
			if(setofallusers.get(pid).followers.ithelement(i).uid.equals(uid1)) {
				b1=true;
				setofallusers.get(pid).followers.ithelement(i).time=time1;
				setofallusers.get(pid).followers.ithelement(i).subscription="SUBSCRIBE";
			}
		}
		if(b1==false) {
			usertimepair utp=new usertimepair(uid1,time1,"SUBSCRIBE");  //uid1 becomes follower of pid
			setofallusers.get(pid).followers.addElement(utp);//getting the pid and subscribed by uid1
		}
		if(b2==false) {
			usertimepair utp1=new usertimepair(pid,time1,"SUBSCRIBE");
			setofallusers.get(uid1).follows.addElement(utp1);
		}
	}
	public String Unsubscribe(int time1,String uid1,String pid) {
		boolean b1=false;
		if(setofallusers.get(uid1)!=null && setofallusers.get(uid1).follows.length()>0) {
			//System.out.println(b1+" b1");
			for(int i=0;i<setofallusers.get(uid1).follows.length();i++) {
				//System.out.print(setofallusers.get(uid1).follows.ithelement(i).uid + " "+setofallusers.get(uid1).follows.ithelement(i).subscription+" ");
				if(setofallusers.get(uid1).follows.ithelement(i).uid.equals(pid) && setofallusers.get(uid1).follows.ithelement(i).subscription.equals("UNSUBSCRIBE")) {
					b1=true;
					//System.out.println(b1);
				}
			}
		}
		 if(setofallusers.get(uid1)==null) {
			return ("uid "+uid1+" has not subscribed to pid "+pid);
		}
		else if(b1==true) {
			return ("uid "+uid1+" has not subscribed to pid "+pid);
		}
		
		else if(setofallusers.get(pid)==null) {
			return ("User with "+pid+" does not exist");
		}
		
		User u= setofallusers.get(uid1);
		User u2= setofallusers.get(pid);
		boolean b=false;
		for(int i=0;i<u.follows.length();i++) {
			if(u.follows.ithelement(i).uid.equals(pid)) {
				b=true;
				u.follows.ithelement(i).subscription="UNSUBSCRIBE";    // if found unsubscribed!
				//System.out.println(b+" b");
			}
		}
		if(b==true) {
			for(int j=0;j<u2.followers.length();j++) {
				if(u2.followers.ithelement(j).uid.equals(uid1)) {
					u2.followers.ithelement(j).subscription="UNSUBSCRIBE";
				}
			}
		}
		if(b==false) {
			return ("uid "+uid1+" has not subscribed to pid "+pid);
		}
		else {
			return "";
		}
	}
    public String Read(int time1,String uid) {
    	String s="";
    	User u= setofallusers.get(uid);
        if(u.screen.size()==0) {
    		return ("no text available for uid "+uid);
    	}
    	//Vector<String> v = new Vector<String>();
    	for(int i=0;i<u.screen.size();i++) {
    		//System.out.println(setofallusers.get(uid).follows.ithelement(i).uid+" ");
    		if(u.screen.get(i).time<time1) {
    			//System.out.println(u.screen.get(i).uid);
    			s=s+(u.screen.get(i).text)+", ";
    		}
    	}
    	return ("["+s.substring(0,(s.length()-2))+"]");
    }
    
    public void performAction(String actionMessage) {
    	 String[] partial=actionMessage.split(",");
		 String x1 = partial[0];
		 
		 
		 if( actionMessage.length()>=1 && x1.equals("SUBSCRIBE")) {    //PUBLISH SUBSCRIBE
	   		 Subscribe(Integer.valueOf(partial[1]),partial[2],partial[3]);
	   		System.out.println(actionMessage);
	 	   }
		 else if( actionMessage.length()>=1 && x1.equals("UNSUBSCRIBE")) {    //PUBLISH UNSUBSCRIBE
	   		String s= Unsubscribe(Integer.valueOf(partial[1]),partial[2],partial[3]);
	   		if( s.equals("")) {
	   			System.out.println(actionMessage);
	   		}
	   		else{
	   			System.out.println(s);	
	   		}
	 	   }
		 else if( actionMessage.length()>=9 && partial[3].equals("NEW")) {    //PUBLISH NEW
   		 publishnew(Integer.valueOf(partial[1]),partial[2],partial[3],partial[4],partial[5]);
   		System.out.println(actionMessage);
 	   }
		
		 else if( actionMessage.length()>=9 && (partial[3].substring(0,6)).equals("REPOST")) {    //PUBLISH REPOST
			 String x3=(partial[3].substring(0,6));
			 String x4=(partial[3].substring(7,8));
			// publishrepost(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4]);
	   		if(publishrepost(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4]).equals("")) {
	   			System.out.println(actionMessage);
	   		}
	   		else {
	   			System.out.println(publishrepost(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4]));
	   		}
	 	   }
		 else if( actionMessage.length()>=9 && (partial[3].substring(0,5)).equals("REPLY")) {    //PUBLISH REPLY
			 String x3=(partial[3].substring(0,5));
			 String x4=(partial[3].substring(6,7));//
			// publishreply(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4],partial[5]);
	   		if(publishreply(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4],partial[5]).equals("")) {
	   			System.out.println(actionMessage);
	   		}
	   		else {
	   			System.out.println(publishreply(Integer.valueOf(partial[1]),partial[2],x3,x4,partial[4],partial[5]));
	   		}
	 	   }
		 
		 else if( actionMessage.length()>=1 && x1.equals("READ")) {    //PUBLISH READ
			 String s=Read(Integer.valueOf(partial[1]),partial[2]);
			 if(s.substring(0,2).equals("no")) {
				 System.out.println(Read(Integer.valueOf(partial[1]),partial[2]));
			 }
			 else {
				 System.out.println(actionMessage+","+s);
			 }
	 	   }
    }
}
