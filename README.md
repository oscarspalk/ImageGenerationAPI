# ImageGenerationAPI
This is a simple API built with Spring, yet it can be useful, and I am planning on extending its features in the future. I myself use this for my Discord bot.
<br>
You are welcome to clone this, and host your own and add features. But you can access an online version of it at: https://image-generation-api.herokuapp.com/

## /drawS Endpoint
Parameters:
- `string` required
- `xSize` optional, defaults to 100
- `ySize` optional, defaults to 100
- `fontSize` optional, defaults to 16
- `fontColor` optional, defaults to ffffff (only hex without hashtag)
- `backgroundColor` optional, defaults to 000000 (only hex without hashtag)
- `xPosition` optional, defaults to 0
- `yPosition` optional, defaults to 0
- `centered` optional, defaults to false

[Example](https://image-generation-api.herokuapp.com/drawS?string=oscar&xSize=600&centered=true&ySize=600&fontSize=120&fontColor=000000&backgroundColor=ffffff)
