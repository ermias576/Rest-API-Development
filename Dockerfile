#### Author : https://github.com/ermias576/Rest-API-Development ###

# Use and install node v16 first
FROM node:16


COPY package*.json ./

RUN npm install

# Bundle app source
COPY . .

EXPOSE 8080
CMD [ "node", "app.js" ]
