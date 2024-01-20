#!/bin/bash
print ()
{
    log=$*
    timestamp=$(date "+%Y-%m-%d %H:%M:%S")
    echo "${timestamp} :${log}"
}
cd /home/tt/code/CodeForFamily/backend; # make sure we are in the correct folder;
for prc_id in $(ps aux|grep java | awk '{print $2}')
do 
    print "ready to kill ${prc_id}"
    kill -9 $prc_id
done 
print "kill process finish, ready to exec [nohup mvn spring-boot:run] in background"
print "cleaned out the nohup.out file"
echo > nohup.out 
nohup mvn spring-boot:run &
print "backend work script done"
tail -f nohup.out