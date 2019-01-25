

   ##  Contribution
          
          Please contribute to this repository to help it make better. Any change like new question, 
          code improvement, doc improvement etc. is very welcome. Just send me a pull request and 
          I will review the request and approve it if it looks good.
       


# Project-3
##           "A publish-subscribe Social Platform"


we are going to build the basic data structures underlying
publish-subscribe social platforms like Twitter, Instagram etc.


##  Overview
A publish-subscribe system typically has a set of users, U. Each user has
two roles: (a) as a publisher the user is allowed to publish media and as a
(b) reader the user is allowed to view media posted by certain other users.
To keep this assignment manageable we will make the following simplify-
ing assumptions:
1. Time is discrete with no subdivisions, i.e., every action we describe
below will take place at a time t 2 f0; 1; : : :g.
2. The only media publishers are allowed to post are short text of up to
30 characters.
To implement this assignment you will have to assign each user a unique
user id. You will also have to assign each short text a unique text id. Each
short text will also contain a eld which will have a 
ag indicating whether
it is a new text, a republished (reposted) text or a reply to an earlier text.
Now let us see the details of the working of the system.

##  The publishing process. 
Each publisher (user) is allowed to publish only
one short text of up to 30 characters at every time step. This is done through
a PUBLISH action. 


##  The reading process 
Each user subscribes to a set of publishers (who are
also users). At any time t the user may perform a SUBSCRIBE action to
subscribe to a publisher or an UNSUBSCRIBE action to unsubscribe.
To read text posted on the platform the user may perform a READ action.
Let us say the current time at which the user, v, performs a READ action is
t0 and the last time the user performed a read was at time t1 < t0 then a
list of texts are returned. A text x is included in the list

1. If the user who posted x is ux and v subscribed to ux at time ts < t0
and did not unsubscribe from ux between the ts and t0 and

2. if the timestamp tx of x is such that max{t1; ts}<= tx < t0.

3. Or if t1 <=tx < t0 and x is a reply to some text posted by v.

In other words the text should either be a reply to one of v's text from
any user or it should be an unseen text from a publisher that v is currently
subscribed to.
The texts should be output sorted by time. Before a user has performed
any READ we can assume that t1 has some default value like -1 which is
smaller than any allowed timestamp.

##  Actions:
 PUBLISH,t,uid,NEW,text,tid: User uid publish new text at time t
having text id tid.

 PUBLISH,t,uid,REPOST(ptid),tid: User uid repost existing text
represented by text id ptid at time t. The repost text is assigned
a new text id tid.

 PUBLISH,t,uid,REPLY(ptid),text,tid: User uid reply to an exist-
ing text represented by text id ptid at time t. The reply text is
assigned a new text id tid.

 SUBSCRIBE,t,uid,pid: User uid subscribe to a publisher pid at time
t.
 UNSUBSCRIBE,t,uid,pid: User uid unsubscribe to a publisher pid at
time t.

 READ,t,uid: User uid reads text at time t.
