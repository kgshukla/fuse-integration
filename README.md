# JBoss Fuse Quick Start

Click on [Fuse_clickthrough.pdf](https://github.com/kgshukla/fuse-integration/blob/master/Fuse_Clickthrough.pdf) to get started on this example. 

This example demonstrates use of CXF RestFul client that calls a web url (http://freegeoip.com). The response is XML content that is passed to a custom processor (XMLProcessor.java) for further processing. Lastly the processed content is just passed to the log command which prints the output. The log could be replaced with AMQP or Database to store the data.

