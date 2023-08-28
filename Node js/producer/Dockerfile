FROM node:18.16.0
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npm install -g nodemon
CMD ["nodemon", "index.js"]