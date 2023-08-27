# Apache Kafka Demo

This repository provides a basic demonstration of using Apache Kafka to implement a simple messaging system between two microservices: one that generates messages and another that consumes those messages.

## Introduction to Apache Kafka

**Apache Kafka** is an open-source stream processing platform and message broker that is widely used for building real-time data pipelines and streaming applications. It is designed to handle high-throughput, fault tolerance, scalability, and durability of data streams. Kafka is based on a distributed publish-subscribe messaging model and provides strong durability guarantees by persisting messages on disk.

Key concepts in Kafka include:

- **Producer**: A producer is a component that publishes messages to Kafka topics.
- **Consumer**: A consumer is a component that subscribes to Kafka topics and processes the messages.
- **Topic**: A topic is a named stream of records in Kafka where messages are published.
- **Broker**: A Kafka broker is a server that manages the storage, distribution, and retrieval of messages.
- **Partition**: Topics can be divided into partitions for scalability and parallelism.
- **Zookeeper**: Although Kafka now includes its own metadata management, Zookeeper was previously used for distributed coordination within Kafka clusters.

