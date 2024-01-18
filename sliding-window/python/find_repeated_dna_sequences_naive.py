def find_repeated_sequences(s, k):

    # Replace this placeholder return statement with your code
    initial_string = s[0:k]
    # print(initial_string)
    dna_set = set()
    dna_set.add(initial_string)
    repeating_set = set()

    current_index = 1;
    end_index = k + 1;

    while(end_index < len(s)):
        new_string = s[current_index:end_index]
        # print("here's the new string: " + new_string)
        if new_string in dna_set:
            repeating_set.add(new_string)
        else:
            dna_set.add(new_string)
        current_index+=1
        end_index+=1

    return repeating_set
