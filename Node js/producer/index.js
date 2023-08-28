const express = require('express');
const app = express();
const kafka = require('kafka-node');

const client = new kafka.KafkaClient({ kafkaHost: process.env.KAFKA_BOOTSTRAP_SERVERS });
const producer = new kafka.Producer(client);

app.use(express.json());

producer.on('ready', () => {
    console.log('Producer is ready');
    app.post('/', (req, res) => {
        producer.send([{
            topic: process.env.KAFKA_TOPIC, messages: JSON.stringify(req.body)
        }], (err, data) => {
            if (err) {
                console.log('Error in sending message:', err);
                res.status(500).json({ error: 'Error sending message' });
            } else {
                console.log('Message sent successfully:', req.body);
                res.json({ message: 'Message sent successfully' });
            }
        });
    });
});

producer.on('error', (err) => {
    console.error('Producer error:', err);
});

app.listen(process.env.PORT, () => {
    console.log(`Server is running on port ${process.env.PORT}`);
});
