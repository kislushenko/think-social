CREATE TABLE user_subscriptions(
  user_id bigint not null ,
  subscriber_id bigint not null,
  foreign key (user_id) references users (id),
  foreign key (subscriber_id) references users (id)
);