#!/bin/bash
cd /mnt/hgfs/vmshared/training/XXE_deserialization
sudo service apache2 start
#sudo python /mnt/hgfs/vmshared/training/XXE_deserialization/pickle/pickle_vuln.py &
cd /mnt/hgfs/vmshared/training/XXE_deserialization/java_deserialization_1/
sh /mnt/hgfs/vmshared/training/XXE_deserialization/java_deserialization_1/target/bin/webapp &
cd /mnt/hgfs/vmshared/training/XXE_deserialization/java-tomcat-example-app/
sh /mnt/hgfs/vmshared/training/XXE_deserialization/java-tomcat-example-app/target/bin/webapp & 
