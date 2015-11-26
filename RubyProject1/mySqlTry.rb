#!/usr/bin/ruby

require 'mysql2'


client = Mysql2::Client.new(:host => "localhost", :username => "root", :password => "snoopy007", :database => "lean_project_management")
results = client.query("SELECT * FROM etat_tache")
  
results.each do |row|
  # conveniently, row is a hash
  # the keys are the fields, as you'd expect
  # the values are pre-built ruby primitives mapped from their corresponding field types in MySQL
  puts row["code_etat"] # row["id"].class == Fixnum
  if row["label_etat"]  # non-existant hash entry is nil
    puts row["label_etat"]
  end
end
