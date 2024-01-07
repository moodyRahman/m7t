# m7t

m7t is a Minecraft server plugin for Spigot/ Paper. m7t provides a way for developers 
to interact with their server over http, and the ability to run programs on the hosted machine 
depending on what happens in Minecraft. Of course, that's an incredibly dangerous feature, so 
please use this cautiously! 

The initial intent for this project is for me to make what I call an "ignition page", 
a protected website for my players to visit that allows them to turn on the Minecraft 
server for a certain period, and then the Minecraft server shuts itself off. This 
allows players to enjoy Minecraft, with minimal interference for anything my server is running. 
Players should also be able to run commands from within the server if they desire to extend 
their time. 

Additionally, I've always wanted to build a Minecraft server status page that would display 
some data and potentially a web UI to chat with people in the server. 

What this boils down to is an HTTP interface for the internals of a Minecraft server 
that exposes internal details, and allows for the server to interact with the host machine. 
Make sure you take appropriate security measures, such as exposing only reverse proxies 
to certain endpoints, and implementing password protection/ authentication on top. 

**Allow me to reiterate, this plugin should only be run on whitelist-only servers, with 
a trusted user base. It is not meant to be used by anyone apart from me, Moody Rahman**


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.
