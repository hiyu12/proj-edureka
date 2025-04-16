# Base image with PHP + Apache
FROM devopsedu/webapp

# Set working directory
WORKDIR /var/www/html

# Clean existing files and copy source
RUN rm -rf ./*
COPY . .

# Expose default port
EXPOSE 80

# Start Apache
CMD ["apache2ctl", "-D", "FOREGROUND"]

