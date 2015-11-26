# read a csv
counter = 1
File.open("csvExample.txt", "r") do |infile|
    while (line = infile.gets)
        puts "#{counter}: #{line}"
        puts "#{line.chomp.split(';')}"
        array = line.chomp.split(';')
        for row in array
          puts row
          if (row.eql?'b')
            puts 'find'
          end
        end
        counter = counter + 1
    end
end