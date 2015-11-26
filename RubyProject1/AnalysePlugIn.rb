#!/usr/bin/env ruby

require 'rubygems'
require 'zip'

path = ARGV[0]
#path = 'C:\Users\fabien\git\RubyProject1\plugins'
name = ""
version = ""
h = Hash.new();

#---
# Recherche des fichiers dans le répertoires
#---
Dir.foreach(path) do |item|
  # Exclusion et prise en compte que des systalians
  next if item == '.' or item == '..' or !item.include? "systalians"
  # ouverture des jars - en tant que zip
  Zip::File.open(path+'\\'+item) do |zip_file|
    # Analyse de chaque element dans le zip
    zip_file.each do |entry|
      # On ne prend que la MANIFEST
      if ((entry.file?) && (entry.name == "META-INF/MANIFEST.MF"))
        content = entry.get_input_stream.read
        content.each_line do  |line|
          array = line.chomp.split(':')
          if (array[0]=="Bundle-Name")
            name=array[1]
          end  #if
          if (array[0]=="Bundle-Version")
            version=array[1]
          end  #if
        end #do
        # on stocke dans h le nom et la version du plugin
        h[name]=version
      end #if
    end #do
  end #do
end #do


#---
# Tri et restitution
#---
hsorted = h.sort.to_h

hsorted.each do | key , value |
  puts("#{key};#{value}") 
end



