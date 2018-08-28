-- creating users table

 create table if not exists Users(
	user_id serial primary key,
	name text not null,
	email text not null,
	phoneNo text not null,
	password text not null,
	type text,
	dp: text,
	profession: text
);

-- Table: public.places

-- DROP TABLE public.places;

CREATE TABLE if not exists Places
(
  place_id serial NOT NULL,
  name text,
  location text,
  added_by integer,
  pictures text[],
  CONSTRAINT places_pkey PRIMARY KEY (place_id),
  CONSTRAINT places_added_by_fkey FOREIGN KEY (added_by)
      REFERENCES public.users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE if not exists public.reviews
(
   review_id serial, 
   review text, 
   rating integer NOT NULL DEFAULT 0, 
   added_by integer NOT NULL, 
   pictures text[] default , 
   PRIMARY KEY (review_id), 
   FOREIGN KEY (added_by) REFERENCES public.users (user_id) ON UPDATE NO ACTION ON DELETE NO ACTION
) ;

CREATE TABLE if not exists public.comments
(
   comment_id serial, 
   comment text, 
   added_by integer, 
   up_votes integer DEFAULT 0, 
   down_votes integer DEFAULT 0, 
   pictures text[], 
   PRIMARY KEY (comment_id), 
   FOREIGN KEY (added_by) REFERENCES public.users (user_id) ON UPDATE NO ACTION ON DELETE NO ACTION
) 