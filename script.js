async function updateQueueMetrics() {
    try{
        const response = await fetch('https://sqs.us-east-1.amazonaws.com/457528860137/CNC-RESOLUTION-SQS-LINEAR-PAS-MATCHER-PROD');
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log("Queue Metrics:", data);
        // document.getElementById('waiting-count').textContent = data.waiting || 0;
        // document.getElementById('inflight-count').textContent = data.inFlight || 0;
        // document.getElementById('dlq-count').textContent = data.dlq || 0;
    }
    catch(error){
        console.error('Failed to update queue metrics:', error);
        document.getElementById('waiting-count').textContent = 'Error';
        document.getElementById('inflight-count').textContent = 'Error';
        document.getElementById('dlq-count').textContent = 'Error';
    }
}

updateQueueMetrics();

setInterval(updateQueueMetrics, 20000);