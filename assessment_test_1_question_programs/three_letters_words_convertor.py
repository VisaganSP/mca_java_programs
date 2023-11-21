import re


def filter_words(file_path):
    filtered_words = []

    with open(file_path, 'r') as file:
        for line in file:
            # Remove leading and trailing whitespaces
            word = line.strip()

            # Check if the word has exactly 3 letters and contains only letters (no digits)
            if len(word) == 3 and re.match("^[a-zA-Z]+$", word):
                filtered_words.append(word)

    return filtered_words


def save_to_file(words, output_file):
    with open(output_file, 'w') as file:
        for word in words:
            file.write(word + '\n')


# Example usage
file_path = 'english_words.txt'  # Replace with the path to your file
output_file = 'words.txt'

result = filter_words(file_path)
save_to_file(result, output_file)

print(f"Filtered 3-letter words saved to {output_file}.")
