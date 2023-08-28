const express = require('express');
const app = express();
const kafka = require('kafka-node');

// Kafka configuration
const kafkaHost = process.env.KAFKA_BOOTSTRAP_SERVERS;
const topic = process.env.KAFKA_TOPIC;

// Create a Kafka Consumer
const Consumer = kafka.Consumer;
const client = new kafka.KafkaClient({ kafkaHost });
const consumer = new Consumer(client, [{ topic }]);

app.use(express.json());

// Listen for Kafka messages
consumer.on('message', (message) => {
    console.log('Received message:', message.value);
});

// Start the Express server
const port = process.env.PORT || 8082;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
