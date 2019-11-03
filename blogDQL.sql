CREATE TABLE post (
  id INT AUTO_INCREMENT PRIMARY KEY,
  date_of_creation DATE NOT NULL,
  creator_name VARCHAR(30) NOT NULL,
  post_text VARCHAR(1000) NOT NULL
);

CREATE TABLE comment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  date_of_creation DATE NOT NULL,
  creator_name VARCHAR(30) NOT NULL,
  comment_text VARCHAR(250) NOT NULL,
  post_id INT NOT NULL
);