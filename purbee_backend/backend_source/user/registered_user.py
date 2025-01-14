import json

from purbee_backend.backend_source.database.database_utilities import (
    set_profile_picture_by_user_name,
    set_first_name_by_user_name,
    set_last_name_by_user_name,
    set_birth_date_by_user_name,
    get_profile_picture_by_user_name,
    get_first_name_by_user_name,
    get_last_name_by_user_name,
    get_birth_date_by_user_name,
    update_follower_and_following_lists
)


class RegisteredUser:

    def __init__(self, user_name):
        self.user_name = user_name

    def set_profile_info(self, profile_picture, first_name, last_name, birth_date):
        user_name = self.user_name
        if profile_picture:
            set_profile_picture_by_user_name(user_name=user_name, picture=profile_picture)
        if first_name:
            set_first_name_by_user_name(user_name=user_name, first_name=first_name)
        if last_name:
            set_last_name_by_user_name(user_name=user_name, last_name=last_name)
        if birth_date:
            set_birth_date_by_user_name(user_name=user_name, birth_date=birth_date)

        return 0

    def get_profile_info(self):
        user_name = self.user_name
        profile_info = \
            {
                "profile_picture": get_profile_picture_by_user_name(user_name),
                "first_name": get_first_name_by_user_name(user_name),
                "last_name": get_last_name_by_user_name(user_name),
                "birth_date": get_birth_date_by_user_name(user_name)
            }

        return json.dumps(profile_info)

    # user1 follows user2
    # returns 0 for successful update, 1 for error
    def follow_user(self, user_name_of_other_user):
        user_name1 = self.user_name
        user_name2 = user_name_of_other_user
        return update_follower_and_following_lists(user_name1,user_name2)




