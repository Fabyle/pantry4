require 'open-uri'

open("http://www.google.fr"){ |f| 
  f.each_line { |line| p line }    
}