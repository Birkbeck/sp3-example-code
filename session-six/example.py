def get_user(id):
    if id == 1: return "Kier"
    return None

def main():
    user = get_user(2)
    print(user.upper())

main()