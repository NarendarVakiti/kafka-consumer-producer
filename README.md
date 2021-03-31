Method : POST

URL : localhost:8080/writemessage/"Learning kafka"

We can write any message in the place of "Learning kafka" to publish 

Download and Setup Kafka
========================
Download link :: https://kafka.apache.org/downloads

Read bash_profile :: cat ~/.bash_profile

Edit bash_profile :: nano ~/.bash_profile

Add below path to bash_profile :

export PATH="$PATH:/Users/nvakiti/kafka_2.12-2.6.0/bin"

Start Kafka and Zoopkeeper using following command, Go to kafka downloaded folder and run below cmds
> zookeeper-server-start config/zookeeper.properties
> kafka-server-start config/server.properties

First we have to start zookeeper server and then kafka


Create Topic ::
================
Following command is create the topic
> kafka-topics -zookeeper localhost:2181 -topic TEST-TOPIC --create --partitions 3 --replication-factor 1

To check list of topics in kafka ::
> kafka-topics -zookeeper localhost:2181 --list

To know topic description ::
> kafka-topics -zookeeper localhost:2181 --topic TEST-TOPIC --describe

Delete Topic ::
> kafka-topics -zookeeper localhost:2181 --topic TEST-TOPIC --delete

Kafka Producer CLI ::
=====================
To get producer documentation
> kafka-console-producer

Following command is use to write messages into topic
> kafka-console-producer --broker-list localhost:9092 --topic TEST-TOPIC

Kafka Consumer CLI ::
====================

To get consumer documentation
> kafka-console-consumer

To get kafka topic messages
> kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic TEST-TOPIC --from-beginning

Kafka Tool :
============
Download : https://www.kafkatool.com/download.html

We can check what are the topics we created, topic properties, and messages in the topic

Note : Kafka tool will connect after run zookeeper and kafka server.
