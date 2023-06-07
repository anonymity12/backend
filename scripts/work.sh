#!/bin/bash
# this is the script you put in the user directory, when u want to pull newest code(backend), you just run this script by `. work.sh`
cd /home/tt/code/CodeForFamily/backend;
for prc_id in $(ps aux|grep java | awk '{print $2}')
do
	echo "ready to kill ${prc_id}"
	kill -9 $prc_id
done
echo "after kill, git pull newest code..."
git pull
echo "git pull done, re-run backend"
nohup mvn spring-boot:run &
echo "backend work script done"