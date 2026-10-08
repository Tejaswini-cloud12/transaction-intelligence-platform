# Transaction Intelligence Platform

A real-time transaction processing and analytics platform built with Java, Spring Boot, Kafka, Spark, and React.

## What it does

The platform processes transaction events, identifies issues such as duplicates and unusual activity, and provides a dashboard for monitoring and investigation.

I'm also adding an AI layer to help investigate transaction issues and explain what happened using the available transaction and processing data.

## Tech Stack

* Java & Spring Boot
* Apache Kafka
* Apache Spark
* PostgreSQL
* React & TypeScript
* AI/LLM APIs
* Docker & Kubernetes

## Architecture


Transaction → Spring Boot → Kafka → Spark → PostgreSQL
                                      ↓
                              Anomaly Detection
                                      ↓
                               React Dashboard
                                      ↓
                              AI Investigation


## Status

🚧 Currently in development.

Starting with Spark-based transaction analytics and gradually adding real-time streaming, anomaly detection, APIs, dashboard, and AI investigation.
