#!/usr/bin/env ruby

require 'rubygems'
require 'zip'

path = 'C:\Users\fabien\git\RubyProject1\plugins'
name = ""
version = ""
h = Hash.new();




Dir.foreach(path) do |item|
  next if item == '.' or item == '..' or !item.include? "systalians"
  Zip::File.open(path+'\\'+item) do |zip_file|
    # Handle entries one by one
    zip_file.each do |entry|
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
        h[name]=version
      end #if
    end #do
  end #do
end #do



puts h