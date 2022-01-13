# Client_Server messaging pattern
This small project serves as a relatively simple solution of implementing a request/reply using UTF-based sockets.
Two types of components are involved in the network communication; The Application component, and the two Sensor components.
The Application component consists of the layers "presentation" and "domain". The Sensor components both consist of a single "sensor" layer.
### Step 1: Run Co2.Server
### Step 2: Run Temp.Server
### Step 3: Run Application.presentation.Main
Following this procedure will prompt the servers to start transmitting respective Co2 and Temperature readings on their  the given network channel.
The application will try to connect to the servers, and when it does, it will receive the data transmitted, whereafter it will tell the severs to shut down.
